package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/*

ClassLoader - что это такое?

*/

public class Solution {
    public static void main(String[] args) {
        //Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        Set<? extends Animal> allAnimals = getAllAnimals("C:/1/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();
        if (!pathToAnimals.endsWith("\\") && !pathToAnimals.endsWith("/"))
            pathToAnimals = pathToAnimals + "/";
        File dir = new File(pathToAnimals);
        String[] pathes = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir1, String name) {
                return name.toLowerCase().endsWith(".class");
            }
        });
        for (String p : pathes) {
            try {
                final String finalPathToAnimals = pathToAnimals;
                boolean hasInterface = false;
                boolean hasConstructor = false;
                ClassLoader loader = new ClassLoader() {
                    @Override
                    public Class<?> findClass(String className) throws ClassNotFoundException {
                        try {
                            byte[] b = Files.readAllBytes(Path.of(finalPathToAnimals + className + ".class"));
                            return defineClass(null, b, 0, b.length);
                        } catch (FileNotFoundException ex) {
                            return super.findClass(className);
                        } catch (IOException ex) {
                            return super.findClass(className);
                        }
                    }
                };
                String className = p.substring(0, p.length() - 6);
                Class clazz = loader.loadClass(className);
                Class[] interfaces = clazz.getInterfaces();
                for (Class i : interfaces) {
                    if (Animal.class == i) {
                        hasInterface = true;
                        break;
                    }
                }
                if (!hasInterface) continue;
                Constructor[] constructors = clazz.getConstructors();
                for (Constructor c : constructors) {
                    if (c.getParameterTypes().length == 0) {
                        hasConstructor = true;
                        break;
                    }
                }
                if (!hasConstructor) continue;
                result.add((Animal) clazz.getConstructor().newInstance());
            } catch (Exception e) {
            }
        }
        return result;
    }
}
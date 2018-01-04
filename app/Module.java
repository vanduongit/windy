import com.google.inject.AbstractModule;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.google.inject.name.Names;
import services.ApplicationTimer;
import services.AtomicCounter;
import services.Counter;
import windy.framework.core.ICommandHandler;
import windy.framework.core.ICommandHandlerFactory;
import windy.framework.infrastructure.messaging.CommandHandlerFactory;

/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {

    @Override
    public void configure() {
        // Use the system clock as the default implementation of Clock
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
        // Ask Guice to create an instance of ApplicationTimer when the
        // application starts.
        bind(ApplicationTimer.class).asEagerSingleton();
        // Set AtomicCounter as the implementation for Counter.
        bind(Counter.class).to(AtomicCounter.class);

        bind(ICommandHandlerFactory.class).to(CommandHandlerFactory.class);

        //bind(new TypeLiteral<ICommandHandler<CreateBookCommand>>(){}).to(CreateBookCommandHandler.class);
        try {
            Class[] handlerClasses = getClasses("windy.infrastructure.commandhandlers.impl");
            for(int i = 0; i < handlerClasses.length ; i++){
                bind(ICommandHandler.class)
                        .annotatedWith(Names.named(handlerClasses[i].getName().replace("windy.infrastructure.commandhandlers.impl.","")))
                        .to(handlerClasses[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Scans all classes accessible from the context class loader which belong to the given package and subpackages.
     *
     * @param packageName The base package
     * @return The classes
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static Class[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = packageName.replace('.', '/');
        Enumeration resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = (URL) resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList classes = new ArrayList();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, packageName));
        }
        return (Class[]) classes.toArray(new Class[classes.size()]);
    }
    /**
     * Recursive method used to find all classes in a given directory and subdirs.
     *
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
        List<Class> classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }

        return classes;
    }

}

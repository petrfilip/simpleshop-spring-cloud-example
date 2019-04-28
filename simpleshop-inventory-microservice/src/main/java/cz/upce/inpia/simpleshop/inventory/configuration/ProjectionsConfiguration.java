package cz.upce.inpia.simpleshop.inventory.configuration;

import org.axonframework.config.EventHandlingConfiguration;
import org.axonframework.config.ProcessingGroup;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Configuration
public class ProjectionsConfiguration {

    private final EventHandlingConfiguration eventHandlingConfiguration;

    public ProjectionsConfiguration(EventHandlingConfiguration eventHandlingConfiguration) {
        this.eventHandlingConfiguration = eventHandlingConfiguration;
    }

    @PostConstruct
    public void startTrackingProjections() throws ClassNotFoundException {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(TrackedProjection.class));
        for (BeanDefinition bd : scanner.findCandidateComponents("org.demo")) {
            Class<?> aClass = Class.forName(bd.getBeanClassName());
            ProcessingGroup processingGroup = aClass.getAnnotation(ProcessingGroup.class);
            String name = Optional.ofNullable(processingGroup).map(ProcessingGroup::value).orElse(aClass.getPackage().getName());
            registerTrackingProcessor(name);
        }
    }

    private void registerTrackingProcessor(String name) {
        eventHandlingConfiguration.registerTrackingProcessor(name);
    }
}
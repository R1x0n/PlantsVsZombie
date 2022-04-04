module com.supsi.backend {
    exports com.supsi.backend.observers;
    exports com.supsi.backend.observers.utils;

    exports com.supsi.backend.model.plants;
    exports com.supsi.backend.model.zombies;

    opens com.supsi.backend.observers;
    opens com.supsi.backend.observers.utils;
    opens com.supsi.backend.model.plants;
    opens com.supsi.backend.model.zombies;
}

package org.apps.quantitymeasurement.repository;


import org.apps.quantitymeasurement.entity.QuantityMeasurementEntityUC15;

import java.util.*;

public class QuantityMeasurementCacheRepositoryUC15 implements IQuantityMeasurementRepositoryUC15 {

    private static QuantityMeasurementCacheRepositoryUC15 instance;
    private final List<QuantityMeasurementEntityUC15> storage = new ArrayList<>();

    private QuantityMeasurementCacheRepositoryUC15() {}

    public static synchronized QuantityMeasurementCacheRepositoryUC15 getInstance() {
        if (instance == null) {
            instance = new QuantityMeasurementCacheRepositoryUC15();
        }
        return instance;
    }

    @Override
    public void save(QuantityMeasurementEntityUC15 entity) {
        storage.add(entity);
    }

    @Override
    public List<QuantityMeasurementEntityUC15> findAll() {
        return new ArrayList<>(storage); // safe copy
    }
}
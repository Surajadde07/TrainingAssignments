package org.apps.quantitymeasurement.repository;

import org.apps.quantitymeasurement.entity.QuantityMeasurementEntityUC15;

import java.util.List;

public interface IQuantityMeasurementRepositoryUC15 {

    void save(QuantityMeasurementEntityUC15 entity);

    List<QuantityMeasurementEntityUC15> findAll();
}
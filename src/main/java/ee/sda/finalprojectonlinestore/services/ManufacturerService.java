package ee.sda.finalprojectonlinestore.services;

import ee.sda.finalprojectonlinestore.entities.Manufacturer;
import ee.sda.finalprojectonlinestore.repositories.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    final ManufacturerRepository manufacturerRepository;

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }
}

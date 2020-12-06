package ee.sda.finalprojectonlinestore.services;

import ee.sda.finalprojectonlinestore.entities.Category;
import ee.sda.finalprojectonlinestore.entities.Manufacturer;
import ee.sda.finalprojectonlinestore.repositories.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerService {

    final ManufacturerRepository manufacturerRepository;

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    public List<Manufacturer> getAllManufacturers() {
        List<Manufacturer> manufacturerList = new ArrayList<>();
        manufacturerRepository.findAll().forEach(manufacturerList::add);
        return manufacturerList;
    }

    public Manufacturer getManufacturerById(String id) {
        return manufacturerRepository.findById(Long.valueOf(id)).get();
    }

    public void deleteManufacturer(String postId) {
        manufacturerRepository.deleteById(Long.valueOf(postId));
    }
}

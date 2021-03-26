package com.devcenter.apptest.data.db;

import com.devcenter.apptest.data.entity.Brand;
import com.devcenter.apptest.data.entity.Car;
import com.devcenter.apptest.data.entity.Price;
import com.devcenter.apptest.data.repository.BrandRepository;
import com.devcenter.apptest.data.repository.CarRepository;
import com.devcenter.apptest.data.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    private CarRepository carRepository;
    private BrandRepository brandRepository;
    private PriceRepository priceRepository;

    public DbInit(CarRepository carRepository, BrandRepository brandRepository, PriceRepository priceRepository) {
        this.carRepository = carRepository;
        this.brandRepository = brandRepository;
        this.priceRepository = priceRepository;
    }

    @Override
    public void run(String... args) {

        List<Brand> listBrand = Arrays.asList(
                new Brand(1L, "TOYOTA"),
                new Brand(2L, "FORD"),
                new Brand(3L, "FIAT")

        );

        brandRepository.saveAll(listBrand);

        List<Price> listPrice = Arrays.asList(
                new Price(1L, LocalDate.now(), LocalDate.now(), 13.3),
                new Price(2L, LocalDate.now(), LocalDate.now(), 32.3)
        );

        priceRepository.saveAll(listPrice);

        List<Car> listCar = Arrays.asList(
                new Car(1L,"FIESTA", "ROJO",  listBrand.get(1), Arrays.asList(listPrice.get(0))),
                new Car(2L,"COROLLA", "GRIS",  listBrand.get(0), Arrays.asList(listPrice.get(1)))
        );

        carRepository.saveAll(listCar);

        /*List<Usuario> users = Arrays.asList(admin);

        // Guarda usuarios
        this.usuarioDAO.saveAll(users);

        //Creo personas de prueba
        Persona fabio = new Persona("31541622", "Fabio", "Callata", "Cala", "3884166441","3884166441");
        this.personaDAO.create(fabio);

        //Valor maximo para el prestamo 1 millon
        Configuracion configuracion = new Configuracion(new BigDecimal(1000000L));
        configuracionDAO.create(configuracion);*/
    }
}

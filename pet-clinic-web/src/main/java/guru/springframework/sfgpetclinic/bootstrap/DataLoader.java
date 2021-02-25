package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }





    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0)
            loadData();

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry= specialityService.save(dentistry);

        Owner owner1 = new Owner();

        owner1.setFirstName("MMM");
        owner1.setLastName("LLL");
        owner1.setAddress("123 Briisjsj");
        owner1.setCity("Miami");
        owner1.setTelephone("77798789");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(saveDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("OOOO");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("KKK");
        owner2.setLastName("LLL");
        owner2.setAddress("123 Briisjsj");
        owner2.setCity("Miami");
        owner2.setTelephone("77798789");

        Pet fPet = new Pet();
        fPet.setPetType(saveCatPetType);
        fPet.setOwner(owner2);
        fPet.setBirthDate(LocalDate.now());
        fPet.setName("Cat");
        owner2.getPets().add(fPet);

        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();

        vet1.setFirstName("lll");
        vet1.setLastName("kuku");
        vetService.save(vet1);
        vet1.getSpecialities().add(savedRadiology);

        Vet vet2 = new Vet();

        vet2.setFirstName("ljl");
        vet2.setLastName("kuku");
        vetService.save(vet2);
        vet2.getSpecialities().add(savedDentistry);

        System.out.println("Loaded vets");
    }
}

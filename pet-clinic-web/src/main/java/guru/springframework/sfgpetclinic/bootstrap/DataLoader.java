package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }





    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType saveCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();

        owner1.setFirstName("MMM");
        owner1.setSecondName("LLL");

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("KKK");
        owner2.setSecondName("LLL");

        ownerService.save(owner2);

        System.out.println("Loaded owners");

        Vet vet1 = new Vet();

        vet1.setFirstName("lll");
        vet1.setSecondName("kuku");
        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("ljl");
        vet2.setSecondName("kuku");
        vetService.save(vet2);

        System.out.println("Loaded vets");

    }
}

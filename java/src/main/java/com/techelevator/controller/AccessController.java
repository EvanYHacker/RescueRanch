package com.techelevator.controller;

import com.techelevator.dao.AccountDao;
import com.techelevator.dao.AdoptionDao;
import com.techelevator.dao.EmailServiceImpl;
import com.techelevator.dao.PetDao;
import com.techelevator.model.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class AccessController {


        /*
        spring.datasource.username=final_capstone_appuser
        spring.datasource.password=finalcapstone
         */

        private PetDao petDao;
        private AccountDao accountDao;
        private AdoptionDao adoptionDao;
        private EmailServiceImpl emailService;
        private final String header = "Rescue Ranch: Application Approved!";
        private final String rejectionHeader = "Rescue Ranch: Application Status Change";
        private final String adoptionBody = "Congratulations! Your adoption application for a pet Rescue Ranch has been approved! We will contact you within 48 hours to follow up on next steps!";
        private final String volunteerBody = "Congratulations! Your volunteer application for Rescue Ranch has been approved! Please proceed to login at https://www.rescueranch.io/login";
        private final String rejectionBody = "Unfortunately your application to become a volunteer at Rescue Ranch has been rejected.\n This is not a final rejection, and we do consider repeat applicants, however, we recommend waiting at least 6 months between applications. We greatly appreciate your interest in joining our team!";
        private final String adoptionRejection = "Unfortunately, we are not able to approve your adoption application at this time.";


        public AccessController(PetDao petDao, AccountDao accountDao, AdoptionDao adoptionDao, EmailServiceImpl emailService) {
            this.petDao = petDao;
            this.accountDao = accountDao;
            this.adoptionDao = adoptionDao;
            this.emailService = emailService;
        }

        @PreAuthorize("permitAll")
        @RequestMapping(value = "/allpets", method = RequestMethod.GET)
        public List<Pet> getAllPets(){return petDao.findAll();}

        @PreAuthorize("permitAll")
        @RequestMapping(value = "/dogs", method = RequestMethod.GET)
        public List<Pet> getAllDogs(){return petDao.findAllDogs();}

        @PreAuthorize("permitAll")
        @RequestMapping(value = "/cats", method = RequestMethod.GET)
        public List<Pet> getAllCats(){return petDao.findAllCats();}

        @PreAuthorize("permitAll")
        @RequestMapping(value = "/otheranimals", method = RequestMethod.GET)
        public List<Pet> getAllOtherAnimals(){return petDao.findAllOtherAnimals();}

        @PreAuthorize("permitAll")
        @RequestMapping(value = "/search", method = RequestMethod.GET)
        public List<Pet> search(@RequestParam String query){return petDao.getSearchResults(query);}

        @PreAuthorize("permitAll")
        @RequestMapping(value = "/apply", method = RequestMethod.POST)
        public Account petApplicant(@RequestBody Account newApplicant){return accountDao.createApplicant(newApplicant);}

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value = "/applicants", method = RequestMethod.GET)
        public List<Account> applicants(){return accountDao.getApplicants();}

        @RequestMapping(value = "/addpet", method = RequestMethod.POST)
        public Pet addPet(@RequestBody Pet pet){return petDao.addPet(pet);}

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value = "/approve/{id}", method = RequestMethod.POST)
        public List<Account> approve(@PathVariable Long id){
                String email = accountDao.getAccount(id).getEmail();
                emailService.sendSimpleMessage(email,header,volunteerBody);
                accountDao.acceptApplicant(id);
                return accountDao.getApplicants();
        }

        @PreAuthorize("permitAll")
        @RequestMapping(value = "/petinfo/{id}", method = RequestMethod.GET)
        public Pet getIndividualPet(@PathVariable Long id){return petDao.getPetById(id);}

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value = "/deny/{id}", method = RequestMethod.PUT)
        public List<Account> deny(@PathVariable Long id){
                String email = accountDao.getAccount(id).getEmail();
                emailService.sendSimpleMessage(email,rejectionHeader, rejectionBody);
                accountDao.denyApplicant(id);
                return accountDao.getApplicants();
        }

        @RequestMapping(value = "/rancherlist", method = RequestMethod.GET)
        public List<Account> getAllRanchers() {return accountDao.getAllRanchers();}

        @RequestMapping(value = "/updatepet", method = RequestMethod.PUT)
        public Pet updatePet(@RequestBody Pet pet){return petDao.updatePet(pet);}

        @RequestMapping(value = "/removepet/{id}", method = RequestMethod.PUT)
        public boolean removePet(@PathVariable Long id){return petDao.removePet(id);}

        @PreAuthorize("permitAll")
        @RequestMapping(value = "/newadoptionapplication", method = RequestMethod.POST)
        public AdoptionApplication createNewAdoption(@RequestBody AdoptionApplication adoptionApplication){return adoptionDao.createNewAdoption(adoptionApplication);}

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value = "/adoptionapplications", method = RequestMethod.GET)
        public List<AdoptionApplication> getAllAdoptionApplications(){return adoptionDao.getAllAdoptionApplications();}

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value = "/approveadoption/{id}", method = RequestMethod.PUT)
        public List<AdoptionApplication> approveAdoption(@PathVariable Long id){
                String email = adoptionDao.getApplicationById(id).getAdopter_email();
                emailService.sendSimpleMessage(email,header,adoptionBody);
                adoptionDao.approveAdoption(id);
                return getAllAdoptionApplications();
        }

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value = "/rejectadoption/{id}", method = RequestMethod.PUT)
        public List<AdoptionApplication> rejectAdoption(@PathVariable Long id){
                String email = adoptionDao.getApplicationById(id).getAdopter_email();
                emailService.sendSimpleMessage(email,rejectionHeader, rejectionBody);
                adoptionDao.rejectAdoption(id);
                return getAllAdoptionApplications();
        }

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value = "/removeadoption/{id}", method = RequestMethod.PUT)
        public boolean removeAdoption(@PathVariable Long id){return adoptionDao.removeAdoption(id);}

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value = "/removeuser/{id}", method = RequestMethod.PUT)
        public boolean removeUser(@PathVariable Long id){return accountDao.removeUser(id);}

        @PreAuthorize("hasRole('ADMIN')")
        @RequestMapping(value = "/makeuseradmin/{id}", method = RequestMethod.PUT)
        public boolean makeUserAdmin(@PathVariable Long id){return accountDao.promoteUser(id);}

        @PreAuthorize("permitAll")
        @RequestMapping(value = "/adoptedpets", method = RequestMethod.GET)
        public List<Pet> getAllAdoptedPets(){return petDao.getAllAdoptedPets();}

}

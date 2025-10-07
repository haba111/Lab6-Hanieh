package org.example.lab3;

import org.example.lab3.entities.AddressBook;
import org.example.lab3.entities.BuddyInfo;
import org.example.lab3.repository.AddressBookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookViewController {

    private final AddressBookRepository addressBookRepository;

    public AddressBookViewController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    // Show a single AddressBook with form to add Buddy
    @GetMapping("/addressbooks/{id}")
    public String viewAddressBook(@PathVariable Long id, Model model) {
        AddressBook ab = addressBookRepository.findById(id).orElse(null);
        model.addAttribute("addressBook", ab);
        model.addAttribute("newBuddy", new BuddyInfo()); // for form binding
        return "addressbook"; // thymeleaf template name
    }

    // Handle form POST to add a Buddy to AddressBook
    @PostMapping("/addressbooks/{id}/addBuddy")
    public String addBuddyForm(@PathVariable Long id, @ModelAttribute BuddyInfo buddyInfo) {
        AddressBook ab = addressBookRepository.findById(id).orElse(null);
        if (ab != null) {
            ab.addBuddy(buddyInfo);
            addressBookRepository.save(ab);
        }
        return "redirect:/addressbooks/" + id;
    }

    // list all address books with links
    @GetMapping("/addressbooks")
    public String listAddressBooks(Model model) {
        model.addAttribute("addressBooks", addressBookRepository.findAll());
        return "addressbooks";
    }
}

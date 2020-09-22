package application.data.service;


import application.data.model.Contact;
import application.data.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ContactSerive {

@Autowired
    private ContactRepository contactRepository;


@Transactional

    public void addNewContact(Contact contact){
    contactRepository.save(contact);
}

    public void addNewListContact(List<Contact> contact){
        contactRepository.save(contact);
    }



    public Contact findOne(int contactId) {

        return contactRepository.findOne(contactId);
    }

//    public Contact findAll(Contact contact) {
//
//        return contactRepository.findAll(contact);
//    }


    public boolean updateContact(Contact contact) {

        try {
            contactRepository.save(contact);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteContact(int contactId) {
        try {
            contactRepository.delete(contactId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

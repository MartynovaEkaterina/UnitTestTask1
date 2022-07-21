import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneDirectoryTest {

    @Test
    public void testAddGroup() {
        //arrange
        Map<String, List<Contact>> expected = new HashMap<>();
        expected.put("Дом", new ArrayList<>());
        expected.put("Работа", new ArrayList<>());

        //act
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.addGroup("Дом");
        phoneDirectory.addGroup("Работа");
        Map<String, List<Contact>> actual = phoneDirectory.hmap;

        //assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testAddContactToGroup() {
        //arrange
        Contact contact = new Contact("Иван", "Петров", "+79014568732", 32, "M");
        Contact contact1 = new Contact("Павел", "Сидоров", "+79014568733", 22, "M");
        //Contact contact2 = new Contact("Елена", "Макарова", "+79044568738", 17, "WOMAN");
        Contact contact2 = new Contact("Ирина", "Веселая", "+79014578732", 18, "W");
        //Contact contact4 = new Contact("Петр", "Внуков", "+79014578732", 21, "MAN");
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact);
        contacts.add(contact1);
        contacts.add(contact2);
        Map<String, List<Contact>> expected = new HashMap<>();
        expected.put("Друзья", contacts);
        expected.put("Работа", contacts);

        //act
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        String[] groups = new String[]{"Работа", "Друзья"};
        phoneDirectory.addContactToGroup(contact, groups);
        phoneDirectory.addContactToGroup(contact1, groups);
        phoneDirectory.addContactToGroup(contact2, groups);
        Map<String, List<Contact>> actual = phoneDirectory.hmap;

        //assert
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void testGetCountWomanAdultsTheGroup() {
        //arrange
        Contact contact = new Contact("Иван", "Петров", "+79014568732", 32, "M");
        Contact contact1 = new Contact("Павел", "Сидоров", "+79014568733", 22, "M");
        Contact contact2 = new Contact("Ирина", "Веселая", "+79014578732", 18, "W");
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        String[] groups = new String[]{"Работа", "Друзья"};
        phoneDirectory.addContactToGroup(contact, groups);
        phoneDirectory.addContactToGroup(contact1, groups);
        phoneDirectory.addContactToGroup(contact2, groups);
        String groupName = "Работа";
        long expected = 1;

        //act
        long actual = phoneDirectory.getCountWomanAdultsTheGroup(groupName);

        //assert
        Assertions.assertEquals(expected, actual);
    }
}
import java.util.*;

public class PhoneDirectory {
    public Map<String, List<Contact>> hmap = new HashMap<>();

    //Создание группы контактов
    public void addGroup(String groupName) {
        if (hmap.containsKey(groupName)) {
            System.out.println("Группа с таким названием уже существует");
        }
        hmap.put(groupName, new ArrayList<>());
    }

    //Добавление контакта в разные группы
    public void addContactToGroup(Contact contact, String[] groupNames) {
        for (String groupName : groupNames) {
            if (!hmap.containsKey(groupName)) {
                addGroup(groupName);
            }
            List<Contact> currentList = hmap.get(groupName);
            currentList.add(contact);
            hmap.put(groupName, currentList);
        }
    }

    //Вывод групп с контактами
    public void printHmap() {
        if (hmap.isEmpty()) {
            System.out.println("Список пуст!");
        } else {
            System.out.println("Список групп и контактов: ");
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, List<Contact>> element : hmap.entrySet()) {
                sb.append("\n");
                sb.append(element.getKey());
                sb.append("\n");
                for (Contact contactPrint : element.getValue()) {
                    sb.append("\t");
                    sb.append(contactPrint);
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }
    }

    //Количество совершеннолетних женщин в группе
    public long getCountWomanAdultsTheGroup(String groupName) {
        List<Contact> list = hmap.get(groupName);
        long countWoman = list.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getSex().equals("W"))
                .count();
        return countWoman;
    }

    //Количество совершеннолетних мужчин в группе
    public long getCountManAdultsTheGroup(String groupName) {
        List<Contact> list = hmap.get(groupName);
        long countMan = list.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> p.getSex().equals("M"))
                .count();
        return countMan;
    }
}
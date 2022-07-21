import java.util.*;

public class Main {
    public static void main(String[] args) {
        PhoneDirectory contacts = new PhoneDirectory();
        while (true) {
            System.out.println("\nВыберите действие и нажмите ввод: "
                    + "\n1. Создать группу"
                    + "\n2. Добавить контакт"
                    + "\n3. Вывести список групп и контактов"
                    + "\n4. Вывести количество совершеннолетних женщин в группе"
                    + "\n5. Вывести количество совершеннолетних мужчин в группе"
                    + "\n0. Выход");
            try {
                Scanner scanner = new Scanner(System.in);
                int userSelection = scanner.nextInt();
                if (userSelection == 0) {
                    System.out.println("До встречи!");
                    break;
                } else {
                    switch (userSelection) {
                        case 1: {
                            while (true) {
                                System.out.println("\nВведите название группы (для завершения введите нет): ");
                                Scanner scanner2 = new Scanner(System.in);
                                String groupName = scanner2.next();
                                if ("нет".equals(groupName)) {
                                    break;
                                } else {
                                    contacts.addGroup(groupName);
                                }
                            }
                            break;
                        }
                        case 2: {
                            while (true) {
                                System.out.println("\nВведите через пробел имя, фамилию, телефон абонента, возраст, пол: M-мужской/ W-женский (для завершения введите нет): ");
                                Scanner scanner3 = new Scanner(System.in);
                                String contactInfo = scanner3.nextLine();
                                if ("нет".equals(contactInfo)) {
                                    break;
                                } else {
                                    String[] contactInfoDetail = contactInfo.split(" ");
                                    String contactName = contactInfoDetail[0];
                                    String contactSurname = contactInfoDetail[1];
                                    String contactPhoneNumber = contactInfoDetail[2];
                                    int contactAge = Integer.parseInt(contactInfoDetail[3]);
                                    String contactSex = contactInfoDetail[4];
                                    Contact contact = new Contact(contactName, contactSurname, contactPhoneNumber, contactAge, contactSex);
                                    System.out.println("\nУкажите группы контакта через пробел: ");
                                    Scanner scanner4 = new Scanner(System.in);
                                    String groupInfo = scanner4.nextLine();
                                    String[] groups = groupInfo.split(" ");
                                    contacts.addContactToGroup(contact, groups);
                                }
                            }
                            break;
                        }
                        case 3: {
                            contacts.printHmap();
                            break;
                        }
                        case 4: {
                            System.out.println("\nУкажите наименование группы: ");
                            Scanner scanner5 = new Scanner(System.in);
                            String groupName = scanner5.nextLine();
                            System.out.println(contacts.getCountWomanAdultsTheGroup(groupName));
                            break;
                        }
                        case 5: {
                            System.out.println("\nУкажите наименование группы: ");
                            Scanner scanner6 = new Scanner(System.in);
                            String groupName = scanner6.nextLine();
                            System.out.println(contacts.getCountManAdultsTheGroup(groupName));
                            break;
                        }
                    }
                }
            } catch (InputMismatchException exception) {
                System.out.println("\nОшибка ввода! Повторите попытку");
            } catch (NullPointerException exception2) {
                System.out.println("\nУказанной группы нет в справочнике!");
            }
        }
    }
}

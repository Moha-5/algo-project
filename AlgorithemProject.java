/*
in this code we will solve to problems most of face in a daily basis 
1. contacts list
    most of us don't realise it but our contacts list uses one of the sorting algorithem most commenly (mergesort or quicksort)
2. Serching for a specific contact
    for this one we will use binary search  
*/
// in the next functions we basically declared a new type of variables 
class Contact implements Comparable<Contact> {
    private String name;

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Contact other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

class AlgorithemProject{
    public static void main(String[] args) {
        Contact[] contacts = {
            new Contact("Mohammed"),
            new Contact("Fatima"),
            new Contact("Ahmed"),
            new Contact("Aisha"),
            new Contact("Ali"),
            new Contact("Layla"),
            new Contact("Omar"),
            new Contact("Nour"),
            new Contact("Hassan"),
            new Contact("Waleed"),
            new Contact("Youssef"),
            new Contact("Sara"),
            new Contact("Khalid"),
            new Contact("Yasser")
        };
        // Print unsorted contacts
        System.out.println("Unsorted Contacts:");
        printContacts(contacts);

        // Sort contacts using quicksort
        quicksort(contacts, 0, contacts.length - 1);

        // Print sorted contacts
        System.out.println("\nSorted Contacts:");
        printContacts(contacts);

        // Perform binary search for a contact
        String searchName = "Sara";
        int index = binarySearch(contacts, searchName);

        if (index != -1) {
            System.out.println("\nContact found at index " + index + ": " + contacts[index]);
        } else {
            System.out.println("\nContact not found: " + searchName);
        }
    }
    // Quicksort implementation
    private static void quicksort(Contact[] contacts, int p, int q) {
        if (p < q) {
            int pivotIndex = partition(contacts, p, q);
            quicksort(contacts, p, pivotIndex - 1);
            quicksort(contacts, pivotIndex + 1, q);
        }
    }
    // Partitioning step of quicksort
    private static int partition(Contact[] contacts, int p, int q) {
        Contact pivot = contacts[q];
        int i = p - 1;

        for (int j = p; j < q; j++) {
            if (contacts[j].compareTo(pivot) <= 0) {
                i++;
                swap(contacts, i, j);
            }
        }

        swap(contacts, i + 1, q);
        return i + 1;
    }
    // Utility method to swap elements in an array
    private static void swap(Contact[] contacts, int index1, int index2){
        Contact temp = contacts[index1];
        contacts[index1] = contacts[index2];
        contacts[index2] = temp;
    }
    // Binary search implementation
    private static int binarySearch(Contact[] contacts, String target) {
        int low = 0;
        int high = contacts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = contacts[mid].compareTo(new Contact(target));

            if (comparison == 0) {
                return mid; // Contact found
            } else if (comparison < 0) { // The middle element is less than the target
                low = mid + 1;// So we search in the right sub array
            } else { // The middle element is greater than the target
                high = mid - 1;// So we search in the left sub array
            }
        }

        return -1; // Contact not found
    }
    // Utility method to print an array of contacts
    private static void printContacts(Contact[] contacts) {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
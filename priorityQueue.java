
/*
 * Create the Student and Priorities classes here.
 */
import java.util.*;

class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() { return id; }
    public String getName() { return name; }
    public double getCGPA() { return cgpa; }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        // Explicitly specify <Student> and provide an initial capacity for Java 7 compatibility
        PriorityQueue<Student> pq = new PriorityQueue<Student>(events.size(), new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getCGPA() != s2.getCGPA()) {
                    return Double.compare(s2.getCGPA(), s1.getCGPA());
                }
                if (!s1.getName().equals(s2.getName())) {
                    return s1.getName().compareTo(s2.getName());
                }
                return Integer.compare(s1.getID(), s2.getID());
            }
        });

        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> remainingStudents = new ArrayList<Student>();
        while (!pq.isEmpty()) {
            remainingStudents.add(pq.poll());
        }
        return remainingStudents;
    }
}



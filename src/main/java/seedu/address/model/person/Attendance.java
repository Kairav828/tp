package seedu.address.model.person;

public class Attendance {
    public static final int MAX_WEEKS = 13;
    private final boolean[] attendance;

    public Attendance() {
        this.attendance = new boolean[MAX_WEEKS];
    }

    public void markWeek(int week) {
        if (week >= 1 && week <= MAX_WEEKS) {
            attendance[week - 1] = true;
        }
    }

    public boolean isMarked(int week) {
        if (week >= 1 && week <= MAX_WEEKS) {
            return attendance[week - 1];
        }
        return false;
    }

    public boolean[] getAttendanceRecord() {
        return attendance.clone();
    }

     /**
     * Returns a string representation of the attendance record.
     * Each week is represented as "Attended" or "Absent" based on the
     * attendance status for that week.
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_WEEKS; i++) {
            sb.append("Week ").append(i + 1).append(": ").append(attendance[i] ? "Attended" : "Absent").append("\n");
        }
        return sb.toString();   
    }

    @Override 
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Attendance)) {
            return false;
        }

        Attendance otherAttendance = (Attendance) other;
        for (int i = 0; i < MAX_WEEKS; i++) {
            if (this.attendance[i] != otherAttendance.attendance[i]) {
                return false;
            }
        }
        return true;
    }      

    @Override
    public int hashCode() {
        int result = 1;
        for (boolean weekAttendance : attendance) {
            result = 31 * result + (weekAttendance ? 1 : 0);
        }
        return result;
    }
}

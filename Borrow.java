package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Borrow {
    private String borrowingId;
    private String userName;
    private String bookTitle;
    private String borrowingDate;
    private String dueDate;
    private String approvalStatus;
    private double fines;
    // to read
    public Borrow(String borrowingId,String userName, String bookTitle, String borrowingDate, String dueDate, String approvalStatus, double fines){
        this.borrowingId=borrowingId;
        this.userName=userName;
        this.bookTitle=bookTitle;
        this.borrowingDate=borrowingDate;
        this.dueDate=dueDate;
        this.approvalStatus=approvalStatus;
        this.fines=fines;

    }

    // to write
    public Borrow(String userName, String bookTitle, String borrowingDate, String dueDate, String approvalStatus, double fines){
        this.borrowingId=UUID.randomUUID().toString().substring(0, 6);
        this.userName=userName;
        this.bookTitle=bookTitle;
        this.borrowingDate=borrowingDate;
        this.dueDate=dueDate;
        this.approvalStatus=approvalStatus;
        this.fines=fines;

    }

    public String getBorrowingId() {
        return borrowingId;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBorrowingDate() {
        return borrowingDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus){
        this.approvalStatus=approvalStatus;
    }
    
    public void setUsername(String userName){
        this.userName=userName;
    }

    public boolean isOverdue() {
        if (dueDate == null || dueDate.isEmpty()) {
            return false;  
        }
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate due = LocalDate.parse(dueDate, FORMATTER);
        return LocalDate.now().isAfter(due);
    }

    public void calculateFines() {
        if (isOverdue()) {
            this.fines = 100; 
        } else {
            this.fines = 0; 
        }
    }

    public double getFines() {
        calculateFines(); 
        return fines;
    }

    public String toString() {
        return borrowingId + "," + userName + "," + bookTitle + "," + borrowingDate + "," + dueDate + "," + approvalStatus+ "," + fines;
    }

    public static Borrow fromFileFormat(String line) {
        String[] parts = line.split(",");
        return new Borrow(parts[0], parts[1], parts[2], parts[3] , parts[4], parts[5],Double.parseDouble(parts[6]));
    }

}

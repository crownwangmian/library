class EBook extends Book {

    private double fileSize;

    public EBook(String title, double price, double fileSize) {
        super(title, price);
        this.fileSize = fileSize;

    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.printf("File Size: %.2f MB\n", fileSize);
    }

}

public class Number {

    private int num;

    Number() {};

    Number(int num, String strNum) {
        this.num = num;
    };

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    void setNum(String num) {

        try
        {
            this.num = Integer.parseInt(num.trim());
            //System.out.println("int i = " + num1);
        }
            catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
    }
}

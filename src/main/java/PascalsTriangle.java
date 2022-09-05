import java.util.ArrayList;
import java.util.List;
class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        if(numRows<=0)
        {
            return list;
        }

        for(int line = 1; line <= numRows; line++)
        {

            List<Integer> l1 = new ArrayList<>();
            int C=1;// used to represent C(line, i)

            for(int i = 1; i <= line; i++)
            {
                l1.add(C);
                // The first value in a line is always 1
                C = C * (line - i) / i;

            }
            list.add(l1);
        }

        return list;

    }

    public static void main(String[] args){
        System.out.println(generate(5));
    }
}
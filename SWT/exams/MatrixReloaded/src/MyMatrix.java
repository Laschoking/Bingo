import java.awt.*;
import java.util.*;


public class MyMatrix<T> implements Matrix<T> {
    private Point point;
    HashMap<Point,T> matrix;
    ArrayList<Integer> xList ;
    ArrayList<Integer> yList;
    Set<T> distinctObj;



    public MyMatrix(){
        matrix = new HashMap<>();
        xList = new ArrayList<>();
        yList = new ArrayList<>();
        distinctObj = new TreeSet<>();
    }
    
    @Override // xList extra Liste mit allen Werten
    public int getColumnCount() {
        if (xList.isEmpty()) return 0;
        int tmp = (int) Collections.max(xList);
        return tmp + 1;
    }
    //Integer richtig?
    @Override
    public int getRowCount() {
        if (yList.isEmpty()) return 0;

        int tmp = (int) Collections.max(yList);
        return tmp + 1;
    }

    @Override // Anzahl der elemente in hashmap, ausser null wurde eingeben
    public int getObjectCount() {
        return matrix.size();
    }

    @Override
    public int getDistinctObjectCount() {
        int counter = 0;
        while(counter < xList.size()){
            point = new Point(xList.get(counter), yList.get(counter));
            distinctObj.add(matrix.get(point));
            counter++;
        }

        return distinctObj.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new DepthFirstIterator();
    }

    private class DepthFirstIterator implements Iterator<T>{
        int xi = 0;
        int yi = 0;


        @Override
        public boolean hasNext() {
            int xMax = Collections.max(xList);
            int yMax = yList.get(xList.indexOf(xMax));

            if (xi == xMax){
                return false;
            }else return true;
        }

        @Override
        public T next() {

            while (xi <= Collections.max(xList)){
                while (yi <= Collections.max(yList)){
                    point = new Point(xi,yi);
                    if(matrix.containsKey(point)){
                        System.out.print(xi);
                        System.out.print(" " + yi);
                        T help = matrix.get(point);
                        System.out.println(" " + help);
                        yi++;
                        return help;
                    }
                    yi++;
                }
                yi = 0;
                xi++;
            }
            throw new NoSuchElementException();

        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public T get(int row, int column) {
        if(row > Collections.max(yList) || column > Collections.max(xList)){
            throw new IllegalArgumentException();
        }
        point = new Point(column,row);
        if (matrix.containsKey(point))return matrix.get(point);
        else return null;

    }


    @Override// row = y , column = x
    public T put(int row, int column, T value) {
        T tmp;
        point = new Point(column,row);
        //put() return automatisch V (value)
        tmp = matrix.put(point,value);
        xList.add(column);
        yList.add(row);
        return tmp;
    }

    @Override
    public boolean contains(T value) {
        return matrix.containsValue(value);
    }
}



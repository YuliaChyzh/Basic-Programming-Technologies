package lab7;

import java.util.*;

public abstract class Coll<Tax> implements List<Tax>
{
    public int a=15;
    private Tax[] mass;
    private int counter;
    public Coll()
    {
        mass = (Tax[])new Object[a];
        counter = 0;
    }
    public Coll(Tax t)
    {
        mass = (Tax[])new Object[a];
        counter =0;
        add(t);
    }
    public Coll(ArrayList<Tax> m)
    {
        mass = (Tax[])new Object[m.size()];
        counter = m.size();
        for(int i = 0;i < m.size();i++)
        {
            mass[i] = m.get(i);
        }
    }


    public void setMass(Tax[] mass) {
        this.mass = mass;
    }

    @Override
    public int size() {
        return mass.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Tax> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Tax tax) {
        Double prsent = (mass.length*0.3);
        Tax[] temp = (Tax[])new Object[mass.length+prsent.intValue()];
        for(int i = 0;i < mass.length;i++)
        {
            temp[i] = mass[i];
        }
        temp[counter] = tax;
        counter++;
        mass = temp;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Tax> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Tax> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Tax get(int index) {
        return mass[index];
    }

    @Override
    public Tax set(int index, Tax element) {
        return null;
    }

    @Override
    public void add(int index, Tax element) {   }

    @Override
    public Tax remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Tax> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Tax> listIterator(int index) {
        return null;
    }

    @Override
    public List<Tax> subList(int fromIndex, int toIndex) {
        return null;
    }

    public Tax[] getMass() {
        return mass;
    }

    public void printColl()
    {
        System.out.print("[ ");
        for(int i = 0;i < getMass().length;i++)
        {
            Tax e = mass[i];
            System.out.print(e + " ");
        }
        System.out.println("]");
    }
}

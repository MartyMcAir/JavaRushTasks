package com.javarush.task.task21.task2108;

import java.util.Arrays;

public class Tmp {
    public static void main(String[] args) throws CloneNotSupportedException {
        Solution.Tree tr = new Solution.Tree("plant", new String[]{"ff", "zzz"});
        Solution.Tree clone = tr.clone();
        clone.setBranches(new String[]{"amp", "zed"});
        System.out.println(Arrays.toString(clone.getBranches()));
        System.out.println(Arrays.toString(tr.getBranches()));
    }
}

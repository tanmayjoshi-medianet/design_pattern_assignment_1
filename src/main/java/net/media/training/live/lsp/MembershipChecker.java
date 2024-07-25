package net.media.training.live.lsp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: goyalamit
 * Date: Jul 12, 2011
 * Time: 1:05:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class MembershipChecker {

    public static <T> boolean check(List<T> elements, CustomSet<T> uniqueElements) {
        for (T element : elements) {
            if (!uniqueElements.isMember(element))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("b");
        elements.add("c");


        CustomSet<String> uniqueElements = new PersistentSet<String>();
        uniqueElements.add("c");
        uniqueElements.add("b");
        uniqueElements.add("a");

        System.out.println("Check1: " + MembershipChecker.check(elements, uniqueElements));

        List<String> anotherElements = new ArrayList<>();
        anotherElements.add("a");
        anotherElements.add("c");
        anotherElements.add("d");

        System.out.println("Check2: " + MembershipChecker.check(anotherElements, uniqueElements));
    }
}

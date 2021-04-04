package item26;

import java.util.ArrayList;
import java.util.List;

public class RawItem {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        unsafeAdd(stringList,0);
        stringList.get(0);
        //아래와 같은 방법은 좋지 않다
        //컴파일시에 에러를 발생하지 않기 때문에
        //로 타입은 클래스 리터럴과 instanceof 연산자를 제외하고는 사용하지 않는것이 좋다.
    }

    private static void unsafeAdd(List list,Object o){
        list.add(o);
    }


}

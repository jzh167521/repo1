package cn.itcast.demo;


import cn.itcast.demo.entity.UserEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class UserSendThread implements Runnable{
    private List<UserEntity> listUser;

    public UserSendThread(List<UserEntity> listUser) {
        this.listUser = listUser;
    }

    public void run() {
        for (UserEntity userEntity : listUser) {
            System.out.println(Thread.currentThread().getName()+"--"+userEntity.toString());
        }
        System.out.println();
    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {
        List<UserEntity> userEntities = initUser();
        int count = 2;
        List<List<UserEntity>> lists = ListUtils.splitList(userEntities, count);
        for (int i = 0; i < lists.size(); i++) {
            List<UserEntity> userEntities1 = lists.get(i);
            // 吧集合放到线程中让线程跑
            UserSendThread userSendThread = new UserSendThread(userEntities1);
            // 分配发送
            Thread thread = new Thread(userSendThread,"线程"+i);
            thread.start();
        }
    }
    static  private  List<UserEntity> initUser(){
     List<UserEntity> userEntities = new ArrayList<UserEntity>();
        for (int i = 0; i < 11; i++) {
            userEntities.add(new UserEntity("userId"+i,"userName"+i));
        }
       Set set = new HashSet();
        Vector<Object> objects = new Vector<Object>();
        objects.remove("");
        Hashtable hashtable = new Hashtable();
    hashtable.put(null,null);

        HashMap hashMap = new HashMap();
    hashMap.put(null,null);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


        Collections.synchronizedList(userEntities);
Collections.synchronizedMap(hashMap);
Collections.synchronizedSet(set);

        return userEntities;
    }
}

package com.example.customspinnerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CustomPopWindow extends PopupWindow {
    private Context context;
    private View view;

    @SuppressLint("ClickableViewAccessibility")
    public CustomPopWindow(Context context, View.OnClickListener itemsOnClick) {
        this.context = context;
        this.view = LayoutInflater.from(context).inflate(R.layout.pop_window, null);
        // 设置外部可点击
        this.setOutsideTouchable(true);
        // 添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.view.setOnTouchListener((v, event) -> {
            int height = view.findViewById(R.id.pop_layout).getBottom();
            int y = (int) event.getY();
            if (event.getAction() == MotionEvent.ACTION_UP) {
                //height+? ?=触发View高度
                if (y > height) {
                    dismiss();
                }
            }
            return true;
        });


        /* 设置弹出窗口特征 */
        // 设置视图
        this.setContentView(this.view);
        // 设置弹出窗体的宽和高
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);


        // 设置弹出窗体可点击
        this.setFocusable(true);



        // 设置弹出窗体显示时的动画，从上往下弹出
        this.setAnimationStyle(R.style.pop_anim);



        ListView listView = view.findViewById(R.id.list_view);

        List<Map<String, Object>> data = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("photo", R.drawable.ic_launcher_background);
        map1.put("name", "小志");
        data.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("photo", R.drawable.ic_launcher_background);
        map2.put("name", "小志的儿子");
        data.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("photo", R.drawable.ic_launcher_background);
        map3.put("name", "小志的老婆");
        data.add(map3);

        Map<String, Object> map4 = new HashMap<>();
        map4.put("photo", R.drawable.ic_launcher_background);
        map4.put("name", "萌萌");
        data.add(map4);
        Map<String, Object> map5 = new HashMap<>();
        map5.put("photo", R.drawable.ic_launcher_background);
        map5.put("name", "萌萌");
        data.add(map5);
        Map<String, Object> map6 = new HashMap<>();
        map6.put("photo", R.drawable.ic_launcher_background);
        map6.put("name", "萌萌");
        data.add(map6);
        Map<String, Object> map7 = new HashMap<>();
        map7.put("photo", R.drawable.ic_launcher_background);
        map7.put("name", "萌萌");
        data.add(map7);



        listView.setAdapter(new SimpleAdapter(context, data, R.layout.list_item,
                new String[] { "photo", "name" }, new int[] { R.id.lv_phono,
                R.id.lv_name }));
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
                //休眠一秒钟


            }


        });
    }





}

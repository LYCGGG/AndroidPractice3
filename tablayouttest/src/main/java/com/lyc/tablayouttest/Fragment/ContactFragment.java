package com.lyc.tablayouttest.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.lyc.tablayouttest.Adapter.MyContactsAdapter;
import com.lyc.tablayouttest.Contacts.MyContacts;
import com.lyc.tablayouttest.ItemClickSupport;
import com.lyc.tablayouttest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：LYC
 * @date ：Created in 2020/10/14
 * @version:
 * @description：
 */
public class ContactFragment extends Fragment {
    private Context mContext;
    private RecyclerView mRecycleView;
    private FloatingActionButton mBtnAddContact;
//    private LoadTask loadingTask = new LoadTask();
    private List<MyContacts> myContactsList = new ArrayList<>();
    private MyContactsAdapter myContactsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        调用onCreateView完立刻调用onViewCreated，前者提供视图，后者创建布局
        super.onViewCreated(view, savedInstanceState);
        mContext = getContext();
        initTest();
        mRecycleView = view.findViewById(R.id.contact_content);
        mRecycleView.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);

        GridLayoutManager layoutManager = new GridLayoutManager(mContext,1);
        mRecycleView.setLayoutManager(layoutManager);

        myContactsAdapter = new MyContactsAdapter(getContext(),myContactsList);
        mRecycleView.setAdapter(myContactsAdapter);//之前居然忘了添加这句话，我佛了

        mBtnAddContact = view.findViewById(R.id.add_contact);
        mBtnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TODO:点击添加新联系人
            }
        });

        ItemClickSupport.addTo(mRecycleView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                // 测试成功
                Toast.makeText(getContext(),"s"+position,Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initTest() {
        myContactsList.clear();
        for (int i=0; i<20; i++){
            String contactsName = "contact" + i;
            MyContacts myContacts = new MyContacts(1,contactsName,null,null);
            myContactsList.add(myContacts);
        }
    }

    // 这个被长期使用的线程处理方式已经被弃用了
    // TODO：换用其他线程、异步技术
//    class LoadTask extends AsyncTask<Void,Void,Void> {
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            return null;
//        }
//
//        public LoadTask() {
//            super();
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//        }
//
//        @Override
//        protected void onProgressUpdate(Void... values) {
//            super.onProgressUpdate(values);
//        }
//
//        @Override
//        protected void onCancelled(Void aVoid) {
//            super.onCancelled(aVoid);
//        }
//
//        @Override
//        protected void onCancelled() {
//            super.onCancelled();
//        }
//    }
}

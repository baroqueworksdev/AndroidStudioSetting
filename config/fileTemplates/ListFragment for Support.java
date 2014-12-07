
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "") package ${PACKAGE_NAME};#end

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

#parse("File Header.java")
public class ${NAME} extends ListFragment implements
        OnItemClickListener, OnItemLongClickListener {
    private static String PUT_LIST_DATA = "listdata";

    private onListItemClickListener mOnListItemClickListener;

    public static ${NAME} newInstance(ArrayList<ContentData> list) {
        ${NAME} fragment = new ${NAME}();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(PUT_LIST_DATA, list);
        fragment.setArguments(bundle);
        return fragment;
    }

    // TODO: need to past to other file
    public class ContentData implements Parcelable {
        @Override
        public int describeContents() {
            return 0;
        }
        @Override
        public void writeToParcel(Parcel out, int flags) {
        }
    }


    public interface onListItemClickListener {
        public void onItemClicked(int postion);

        public void onItemLongClicked(int postion);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof onListItemClickListener) {
            mOnListItemClickListener = (onListItemClickListener) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        ArrayList<ContentData> list = bundle.getParcelableArrayList(PUT_LIST_DATA);
        // TODO: change your layout id
        ConentDataAdapter adapter = new ConentDataAdapter(getActivity(),
                R.layout.list_row, list);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
        getListView().setOnItemLongClickListener(this);

    }

    @Override
    public void onDestroy() {
        mOnListItemClickListener = null;
        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View view, int postion, long id) {
        if (mOnListItemClickListener != null) {
            mOnListItemClickListener.onItemClicked(postion);
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View view, int postion, long id) {
        if (mOnListItemClickListener != null) {
            mOnListItemClickListener.onItemLongClicked(postion);
        }
        return false;
    }

    // TODO: need to change class name
    private class ConentDataAdapter extends ArrayAdapter<ContentData> {
        private ArrayList<ContentData> mList;
        private LayoutInflater mInflater;
        private int mLayoutId;

        private class ViewHolder {
            // TODO: add view object
            TextView mName;
        }

        public ConentDataAdapter(Context context, int textViewResourceId) {
            super(context, textViewResourceId);
            mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mList = new ArrayList<ContentData>();
            mLayoutId = textViewResourceId;
        }

        public ConentDataAdapter(Context context, int textViewResourceId,
                ArrayList<ContentData> list) {
            super(context, textViewResourceId);
            mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mList = list;
            mLayoutId = textViewResourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewHolder holder = null;

            if (view == null) {
                view = mInflater.inflate(mLayoutId, null);
                holder = new ViewHolder();
               // TODO: add view object
                //holder.mName = (TextView) view.findViewById(R.id.name);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();

            }

            // TODO: add view object
            //holder.mName.setText(mList.get(position).getName());

            return view;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public void add(ContentData data) {
            super.add(data);
            mList.add(data);
        }
    }

}

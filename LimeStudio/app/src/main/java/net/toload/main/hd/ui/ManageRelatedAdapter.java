package net.toload.main.hd.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.toload.main.hd.R;
import net.toload.main.hd.data.Related;

import java.util.List;

/**
 * Created by Art Hung on 2015/4/26.
 */
public class ManageRelatedAdapter extends BaseAdapter {

    List<Related> relatedlist;

    Activity activity;
    LayoutInflater mInflater;

    public ManageRelatedAdapter(Activity activity,
                                List<Related> relatedlist) {
        this.activity = activity;
        this.relatedlist = relatedlist;
        this.mInflater = LayoutInflater.from(this.activity);
    }

    @Override
    public int getCount() {
        return relatedlist.size();
    }

    @Override
    public Object getItem(int position) {
        return relatedlist.get(position);
    }

    public List<Related> getList(){
        return relatedlist;
    }

    public void setList(List<Related> list){
        relatedlist = list;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        int type = getItemViewType(position);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.related, null);
            holder = new ViewHolder();
            holder.txtWord = (TextView)convertView.findViewById(R.id.txtWord);
            holder.txtFreq = (TextView)convertView.findViewById(R.id.txtFreq);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }

        Related r = relatedlist.get(position);
        if(r != null){
        	/*holder.chkItemDatetWorde.setText(hwresult.getGenerateDateTWorde());
        	holder.chkItemDatetWorde.setOnCheckedChangeListener(new OnCheckedChangeListener(){
				@Override
				public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
					hwlist.get(position).setCheck(arg1);
				}});*/
            String pword = r.getPword();
            String cword = r.getPword();
            int freq = r.getScore();

            /*if(wordtext.length() > 4){
                wordtext = wordtext.substring(0,3) + "...";
            }*/

            holder.txtWord.setText(pword+" " + cword);
            holder.txtFreq.setText(freq);
        }

        return convertView;

    }

    static class ViewHolder{
        TextView txtWord;
        TextView txtFreq;
    }

    @Override
    public long getItemId(int position) {
        return relatedlist.get(position).getId();
    }


}
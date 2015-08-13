package com.example.javier.complist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.complist.R;
import com.example.javier.complist.componentes.NavDrawerItem;
import com.example.javier.complist.componentes.NavMenuItem;
import com.example.javier.complist.componentes.NavMenuSection;


public class NavDrawerAdapter extends ArrayAdapter<NavDrawerItem> {

    private LayoutInflater inflater;
    private Context context;

    public NavDrawerAdapter(Context context, int textViewResourceId, NavDrawerItem[] objects,
                            Context c) {
        super(context, textViewResourceId, objects);
        this.inflater = LayoutInflater.from(context);
        this.context = c;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null ;
        NavDrawerItem menuItem = this.getItem(position);
        if ( menuItem.getType() == NavMenuItem.ITEM_TYPE ) {
            view = getItemView(convertView, parent, menuItem );
        }
        else {
            view = getSectionView(convertView, parent, menuItem);
        }
        return view ;
    }

    public View getItemView( View convertView, ViewGroup parentView, NavDrawerItem navDrawerItem ) {

        NavMenuItem menuItem = (NavMenuItem) navDrawerItem ;
        NavMenuItemHolder navMenuItemHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate( R.layout.drawer_item, parentView, false);
            TextView labelView = (TextView) convertView
                    .findViewById( R.id.navmenuitem_label );
            ImageView iconView = (ImageView) convertView
                    .findViewById( R.id.navmenuitem_icon );
            TextView countView = (TextView) convertView
                    .findViewById( R.id.navmenuitem_count );

            if(menuItem.getCount()>0) {
                countView.setVisibility(View.VISIBLE);
            }else {
                countView.setVisibility(View.GONE);
            }

            navMenuItemHolder = new NavMenuItemHolder();
            navMenuItemHolder.labelView = labelView ;
            navMenuItemHolder.iconView = iconView ;
            navMenuItemHolder.countView = countView ;

            convertView.setTag(navMenuItemHolder);
        }

        if ( navMenuItemHolder == null ) {
            navMenuItemHolder = (NavMenuItemHolder) convertView.getTag();
        }

        navMenuItemHolder.labelView.setText(menuItem.getLabel());


        if (menuItem.getIcon()!= -1) {
            navMenuItemHolder.iconView.setImageResource(menuItem.getIcon());
        }
        else {
            navMenuItemHolder.iconView.setVisibility(View.GONE);
        }


        navMenuItemHolder.countView.setText(""+menuItem.getCount());


        return convertView ;
    }

    public View getSectionView(View convertView, ViewGroup parentView,
                               NavDrawerItem navDrawerItem) {

        NavMenuSection menuSection = (NavMenuSection) navDrawerItem ;
        NavMenuSectionHolder navMenuItemHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate( R.layout.drawer_section, parentView, false);
            TextView labelView = (TextView) convertView
                    .findViewById( R.id.navmenusection_label );


            navMenuItemHolder = new NavMenuSectionHolder();
            navMenuItemHolder.labelView = labelView ;
            convertView.setTag(navMenuItemHolder);
        }

        if ( navMenuItemHolder == null ) {
            navMenuItemHolder = (NavMenuSectionHolder) convertView.getTag();
        }

        navMenuItemHolder.labelView.setText(menuSection.getLabel());

        return convertView ;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return this.getItem(position).getType();
    }

    @Override
    public boolean isEnabled(int position) {
        return getItem(position).isEnabled();
    }


    private static class NavMenuItemHolder {
        private TextView labelView;
        private ImageView iconView;
        private TextView countView;
    }

    private class NavMenuSectionHolder {
        private TextView labelView;
    }
}

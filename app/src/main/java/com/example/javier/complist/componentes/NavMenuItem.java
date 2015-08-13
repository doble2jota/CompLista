package com.example.javier.complist.componentes;

import android.content.Context;

public class NavMenuItem implements NavDrawerItem{

	public static final int ITEM_TYPE = 1 ;

    private int id ;
    private String label ;
    private int icon ;
    private boolean updateActionBarTitle ;
    private int count;

    private NavMenuItem() {
    }

    public static NavMenuItem create( int id, String label, String icon, boolean updateActionBarTitle,int count, Context context ) {
        NavMenuItem item = new NavMenuItem();
        item.setId(id);
        item.setLabel(label);
        if (icon!= null) {
        	item.setIcon(context.getResources().getIdentifier( icon, "drawable", context.getPackageName()));
        }
        else {
        	item.setIcon(-1);
        }
        item.setUpdateActionBarTitle(updateActionBarTitle);
        item.setCount(count);
        return item;
    }
    
    @Override
    public int getType() {
        return ITEM_TYPE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
    public boolean updateActionBarTitle() {
        return this.updateActionBarTitle;
    }

    public void setUpdateActionBarTitle(boolean updateActionBarTitle) {
        this.updateActionBarTitle = updateActionBarTitle;
    }
}

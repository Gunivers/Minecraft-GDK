package net.gunivers.listgenerator.gui.handlers.list;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class SyncListHandler
{
    private ListView listView1, listView2;

    public SyncListHandler(ListView listView1, ListView listView2)
    {
        this.listView1 = listView1;
        this.listView2 = listView2;

        if (listView1.getSelectionModel().getSelectedItems().size() <= 0 || listView2.getSelectionModel().getSelectedItems().size() <= 0)
        {
            listView1.getSelectionModel().clearAndSelect(0);
            listView2.getSelectionModel().clearAndSelect(0);
        }

        listView1.setOnMousePressed(event -> sync(listView1.getSelectionModel().getSelectedIndex()));

        listView2.setOnMousePressed(event -> sync(listView2.getSelectionModel().getSelectedIndex()));
    }

    /**
     * This method sync the two ListView.
     *
     * @param index is the index of list view.
     */
    public void sync(int index)
    {
        if (listView1.getItems().size() >= index)
            listView1.getSelectionModel().clearAndSelect(index);

        if (listView2.getItems().size() >= index)
            listView2.getSelectionModel().clearAndSelect(index);
    }

    public ListView getListViewOne()
    {
        return listView1;
    }

    public ListView getListViewTwo()
    {
        return listView2;
    }

    public ObservableList getObjectInList(ListNumber number)
    {
        return number == ListNumber.ONE ? listView1.getItems() : listView2.getItems();
    }

    public ListView getListView(ListNumber listNumber)
    {
        return listNumber == ListNumber.ONE ? getListViewOne() : getListViewTwo();
    }

    public void putInAndSelect(ListNumber listNumber, Node value, int index)
    {
        this.putIn(listNumber, value, index);
        getListView(listNumber).getSelectionModel().clearAndSelect(index);
    }

    public void putIn(ListNumber listNumber, Node value, int index)
    {
        ListView listView = getListView(listNumber);

        if (listView.getItems().size() <= index)
        {
            for (int i = listView.getItems().size(); i < index; i++)
            {
                listView.getItems().add(new Label());
            }
        }

        listView.getItems().add(index, value);
    }

    public enum ListNumber
    {
        ONE,
        TWO
    }
}

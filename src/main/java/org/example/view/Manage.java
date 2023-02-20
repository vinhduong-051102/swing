package org.example.view;

import org.example.database.RoomData;
import org.example.database.UserData;
import org.example.model.User;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import java.awt.*;
import java.util.List;


public class Manage extends JFrame {
    private UserData userData;
    private RoomData roomData;
    private JTable table;
    public Manage(UserData userData, RoomData roomData) throws HeadlessException {
        this.userData = userData;
        this.roomData = roomData;
        init();
    }
    public void init() {
        setSize(1000, 1000);
        String[] colsName = {"name", "password"};
        TableModel tableModel = new TableModel(userData);
        table = new JTable(tableModel);
        add(table);
        setVisible(true);

    }
    class TableModel extends AbstractTableModel {
        protected UserData data;

        public TableModel(UserData data) {
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.getAll().size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            User user = data.getAll().get(rowIndex);
           switch (columnIndex) {
               case 0:
                   return user.getName();
               case 1:
                   return user.getPassword();
               default:
                   return null;
           }
        }
    }
}

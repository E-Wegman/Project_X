using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using SQLite;
using PCLStorage;

namespace App2.Droid
{
    class SQLHelper
    {
    }
}

namespace LocalStorage
{
    public class SQLHelper
    {
        static object locker = new object();
        SQLiteConnection database;

        //constructor, om tabellen te maken
        public SQLHelper()
        {
            database = GetConnection();
            database.CreateTable<Data_X.Data>();
        }

        //connectie opzetten met database
        public SQLite.SQLiteConnection GetConnection()
        {
            SQLiteConnection sqLiteConnection;
            var sqliteFilename = "Sampletext.db0";
            IFolder folder = FileSystem.Current.LocalStorage;
            string path = PortablePath.Combine(folder.Path.ToString(), sqliteFilename);
            sqLiteConnection = new SQLite.SQLiteConnection(path);
            return sqLiteConnection;
        }

        //Get data
        public IEnumerable<Data_X.Data> GetItems()
        {
            lock (locker)
            {
                return (from i in database.Table<Data_X.Data>() select i).ToList();
            }
        }

        //public Data_X.Data GetItem(string userName)
        //{
        //    lock (locker)
        //    {
        //        return database.Table<Data_X.Data>().FirstOrDefault(x => x.Username == userName);
        //    }
        //}

        //insert and update data
        public int SaveItem(Data_X.Data item)
        {
            lock (locker)
            {
                if (item.ID != 0)
                {
                    //update items
                    database.Update(item);
                    return item.ID;
                }
                else
                {
                    //insert item
                    return database.Insert(item);
                }
            }
        }
        public int DeleteItem(int id)
        {
            lock (locker)
            {
                return database.Delete<Data_X.Data>(id);
            }
        }
    }
}
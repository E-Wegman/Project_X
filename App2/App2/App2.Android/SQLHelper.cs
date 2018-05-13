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

        public SQLite.SQLiteConnection GetConnection()
        {
            SQLiteConnection sqLiteConnection;
            var sqliteFilename = "Sampletext.db0";
            IFolder folder = FileSystem.Current.LocalStorage;
            string path = PortablePath.Combine(folder.Path.ToString(), sqliteFilename);
            sqLiteConnection = new SQLite.SQLiteConnection(path);
            return sqLiteConnection;
        }
    }
}
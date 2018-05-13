using System;

using Android.App;
using Android.Content.PM;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using Android.OS;
using SQLite;


//Data met Items. Moet nog aangepast worden
namespace Data_X
{
    public class Data
    {
        public Data()
        {
        }

        //Maakt ID de primary key en autoincrement het meteen
        [PrimaryKey, AutoIncrement]
        public int ID { get; set; }
        //Rest van de items die we later ooit gaan aanpassen
        public string Name { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
    }
}

//Automatisch gemaakt door xamarin
namespace App2.Droid
{
    [Activity(Label = "App2", Icon = "@drawable/icon", Theme = "@style/MainTheme", MainLauncher = true, ConfigurationChanges = ConfigChanges.ScreenSize | ConfigChanges.Orientation)]
    public class MainActivity : global::Xamarin.Forms.Platform.Android.FormsAppCompatActivity
    {
        protected override void OnCreate(Bundle bundle)
        {
            TabLayoutResource = Resource.Layout.Tabbar;
            ToolbarResource = Resource.Layout.Toolbar;

            base.OnCreate(bundle);

            global::Xamarin.Forms.Forms.Init(this, bundle);
            LoadApplication(new App());
        }
    }
}


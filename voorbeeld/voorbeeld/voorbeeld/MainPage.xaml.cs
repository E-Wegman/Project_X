﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace voorbeeld
{
	public partial class MainPage : ContentPage
	{
		public MainPage()
		{
			InitializeComponent();
		}
        private async void AgendaButton_OnClicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new Agenda());
        }
	}
}

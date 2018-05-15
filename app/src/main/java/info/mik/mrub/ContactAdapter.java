package info.mik.mrub;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by mik on 5/4/18.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private Context context;
    private List<Contact> contactList;

    public ContactAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // lets show contact_list_row layout as a viewholder
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Create contact model and bind to viewholder
        Contact contact = contactList.get(position);
        holder.name.setText(contact.getName());
        holder.phoneNumber.setText(contact.getPhoneNumber());
        //Uri photoUri = Uri.parse(contact.getPhotoUri());
        //holder.photoUri.setImageURI(photoUri);
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    // Class to implement actual view
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name, phoneNumber;
        //private ImageView photoUri;

        ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            phoneNumber = (TextView) view.findViewById(R.id.phoneNumber);
            //photoUri = (ImageView)view.findViewById(R.id.photoUri);
            // perform an action (open Dialer)
            view.setOnClickListener(this);
            //ScheduleTimer();
        }

        @Override
        public void onClick(View view) {
            // while testing, just make a Toast with a Contact name
            Toast.makeText(context, "Clicked: " + contactList.get(
                    getAdapterPosition()).getName(), Toast.LENGTH_LONG).show();

            // Initialize an intent to open a Dialer app with contact's phone number
            // and allow user to call the number manually
            Intent intentOpenDialer = new Intent(Intent.ACTION_DIAL);

            // Send phone number to intent as data
            intentOpenDialer.setData(Uri.parse("tel:" + contactList.get(
                    getAdapterPosition()).getPhoneNumber()));

            // and send intent in context of the adapter
            context.startActivity(intentOpenDialer);
       }


    }
}

package tr.edu.mu.ceng.mad.week6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class DetailsActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Movie movie = getIntent().getParcelableExtra("movie");
        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        DetailsFragment df = DetailsFragment.newInstance(movie);
        fts.add(R.id.container,df);
        fts.commit();
    }
}

package tr.edu.mu.ceng.mad.week6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "movie";
    private String mParam1;
    Movie movie;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(Movie movie) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, movie);
        fragment.setArguments(args);
        return fragment;
    }

    // TODO: Rename and change types and number of parameters


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
            movie =(Movie) getArguments().getSerializable(ARG_PARAM1);
        }
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details,container,false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setMovie(view,movie);
    }
    public void setMovie(View view, Movie movie) {
        this.movie = movie;
        TextView txtName = (TextView) view.findViewById(R.id.txtMovieName);
        txtName.setText(movie.getName());
        TextView txtYear = (TextView) view.findViewById(R.id.txtYear);
        txtYear.setText(Integer.toString(movie.getYear()));
        TextView txtDirector = (TextView) view.findViewById(R.id.txtDirector);
        txtDirector.setText(movie.getDirector());
        TextView txtDescription = (EditText) view.findViewById(R.id.txtDescription);
        txtDescription.setText(movie.getDescription());
        txtDescription.setEnabled(false);
        ListView listView = (ListView) view.findViewById(R.id.lstStars);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.array_adapter,
                movie.getStars().toArray(new String[1])));
    }

}
package nortti.ru.toad;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import az.plainpie.PieView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static nortti.ru.toad.Consts.NAME;


/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {

    @BindView(R.id.pie1) PieView mPieView1;
    @BindView(R.id.pie2) PieView mPieView2;
    @BindView(R.id.pie3) PieView mPieView3;
    @BindView(R.id.pie4) PieView mPieView4;
    @BindView(R.id.tasks1) TextView mTasks1;
    @BindView(R.id.tasks2) TextView mTasks2;
    @BindView(R.id.tasks3) TextView mTasks3;
    @BindView(R.id.tasks4) TextView mTasks4;

    String name;

    Unbinder mUnbinder;

    public BoardFragment() {
        // Required empty public constructor
    }

    public static BoardFragment newInstance(String name) {

        Bundle args = new Bundle();
        args.putString(NAME,name);
        BoardFragment fragment = new BoardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.add) void OnAdd(){
        final AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = this.getLayoutInflater();
        dialog.setView(inflater.inflate(R.layout.add_dialog, null));
        dialog.setTitle("Add new task");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        dialog.show();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        if (getArguments().containsKey(NAME)){
            name = getArguments().getString(NAME);
            ((TaskActivity)getActivity()).getSupportActionBar().setSubtitle(name);
        }

        mPieView1.setPercentageBackgroundColor(getResources().getColor(R.color.red));
        mPieView2.setPercentageBackgroundColor(getResources().getColor(R.color.blue));
        mPieView3.setPercentageBackgroundColor(getResources().getColor(R.color.orange));
        mPieView4.setPercentageBackgroundColor(getResources().getColor(R.color.green));




        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}

package com.bil496.studifyapp.holder;

/**
 * Created by burak on 3/12/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.bil496.studifyapp.R;
import com.bil496.studifyapp.model.Team;
import com.github.johnkil.print.PrintView;
import com.unnamed.b.atv.model.TreeNode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TeamViewHolder extends TreeNode.BaseNodeViewHolder<TeamViewHolder.TeamItem> {
    @BindView(R.id.arrow_icon) PrintView arrowView;
    @BindView(R.id.icon) PrintView iconView;
    @BindView(R.id.node_value) TextView teamNameLabel;
    @BindView(R.id.size) TextView sizeLabel;
    @BindView(R.id.btn_sendRequest) PrintView sendRequestView;
    public TeamViewHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, TeamItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.node_team, null, false);
        ButterKnife.bind(this, view);
        iconView.setIconText(context.getResources().getString(R.string.ic_people));
        teamNameLabel.setText(value.team.getName() + " ("+value.team.getUtilityScore()+")");
        sizeLabel.setText(value.team.getUsers().size() + " people ");
        sendRequestView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestView.setIconText(context.getResources().getString(R.string.ic_done));
                sendRequestView.setClickable(false);
                // TODO: Send request
            }
        });
        return view;
    }

    @Override
    public void toggle(boolean active) {
        arrowView.setIconText(context.getResources().getString(active ? R.string.ic_keyboard_arrow_down : R.string.ic_keyboard_arrow_right));
    }


    public static class TeamItem {
        public Team team;

        public TeamItem(Team team) {
            this.team = team;
        }
        // rest will be hardcoded
    }

}

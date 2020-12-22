package com.zp.androidx.lint;

import com.android.tools.lint.client.api.IssueRegistry;
import com.android.tools.lint.detector.api.ApiKt;
import com.android.tools.lint.detector.api.Issue;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class MyIssueRegistry  extends IssueRegistry {
    @NotNull
    @Override
    public List<Issue> getIssues() {
        return Arrays.asList(
                LogDetector.ISSUE,
                GlideUnusedDetector.ISSUE
        );
    }

    @Override
    public int getApi() {
        //return super.getApi();
        return ApiKt.CURRENT_API;
    }
}
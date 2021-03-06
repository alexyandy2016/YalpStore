/*
 * Yalp Store
 * Copyright (C) 2018 Sergey Yeriomin <yeriomin@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package com.github.yeriomin.yalpstore.task;

import android.content.Context;
import android.os.AsyncTask;

import com.github.yeriomin.yalpstore.InstallerAbstract;
import com.github.yeriomin.yalpstore.InstallerFactory;
import com.github.yeriomin.yalpstore.model.App;

public class InstallTask extends AsyncTask<Void, Void, Void> {

    private App app;
    private InstallerAbstract installer;

    public InstallTask(Context context, App app) {
        this(InstallerFactory.get(context), app);
    }

    public InstallTask(InstallerAbstract installer, App app) {
        this.installer = installer;
        this.app = app;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        installer.verifyAndInstall(app);
        return null;
    }
}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ArchivioComponent } from './components/archivio/archivio.component';
import { SinglePostComponent } from './components/single-post/single-post.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { AdminComponent } from './components/admin/admin.component';
import { AuthGuard } from './auth/auth.guard';



const routes: Routes = [
	{
    path: "home",
    component: HomeComponent
  },
	{
    path: "archivio",
    component: ArchivioComponent
  },
	{
    path: "post",
    component: SinglePostComponent
  },
	{
    path: "admin",
    component: AdminComponent,
    canActivate : [AuthGuard]
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
	{
    path: "**",
    component: NotFoundComponent
  },

];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }

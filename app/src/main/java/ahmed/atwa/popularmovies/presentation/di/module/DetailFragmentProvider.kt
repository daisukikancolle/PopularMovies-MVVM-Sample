

package ahmed.atwa.popularmovies.presentation.di.module

import ahmed.atwa.popularmovies.presentation.detail.DetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ahmed Atwa on 10/19/18.
 */

@Module
abstract class DetailFragmentProvider {

    @ContributesAndroidInjector(modules =[(DetailFragmentModule::class)])
    internal abstract fun provideDetailFragmentFactory(): DetailFragment

}
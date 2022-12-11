package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AndroidxLibraryAccessors laccForAndroidxLibraryAccessors = new AndroidxLibraryAccessors(owner);
    private final EspressoLibraryAccessors laccForEspressoLibraryAccessors = new EspressoLibraryAccessors(owner);
    private final GlideLibraryAccessors laccForGlideLibraryAccessors = new GlideLibraryAccessors(owner);
    private final PluginLibraryAccessors laccForPluginLibraryAccessors = new PluginLibraryAccessors(owner);
    private final RetrofitLibraryAccessors laccForRetrofitLibraryAccessors = new RetrofitLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for junit (junit:junit)
         * This dependency was declared in catalog libs.toml
         */
        public Provider<MinimalExternalModuleDependency> getJunit() { return create("junit"); }

        /**
         * Creates a dependency provider for leakcanary (com.squareup.leakcanary:leakcanary-android)
         * This dependency was declared in catalog libs.toml
         */
        public Provider<MinimalExternalModuleDependency> getLeakcanary() { return create("leakcanary"); }

        /**
         * Creates a dependency provider for mmkv (com.tencent:mmkv-static)
         * This dependency was declared in catalog libs.toml
         */
        public Provider<MinimalExternalModuleDependency> getMmkv() { return create("mmkv"); }

        /**
         * Creates a dependency provider for rxpermission (com.github.tbruyelle:rxpermissions)
         * This dependency was declared in catalog libs.toml
         */
        public Provider<MinimalExternalModuleDependency> getRxpermission() { return create("rxpermission"); }

    /**
     * Returns the group of libraries at androidx
     */
    public AndroidxLibraryAccessors getAndroidx() { return laccForAndroidxLibraryAccessors; }

    /**
     * Returns the group of libraries at espresso
     */
    public EspressoLibraryAccessors getEspresso() { return laccForEspressoLibraryAccessors; }

    /**
     * Returns the group of libraries at glide
     */
    public GlideLibraryAccessors getGlide() { return laccForGlideLibraryAccessors; }

    /**
     * Returns the group of libraries at plugin
     */
    public PluginLibraryAccessors getPlugin() { return laccForPluginLibraryAccessors; }

    /**
     * Returns the group of libraries at retrofit
     */
    public RetrofitLibraryAccessors getRetrofit() { return laccForRetrofitLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class AndroidxLibraryAccessors extends SubDependencyFactory {
        private final AndroidxCoreLibraryAccessors laccForAndroidxCoreLibraryAccessors = new AndroidxCoreLibraryAccessors(owner);
        private final AndroidxTestLibraryAccessors laccForAndroidxTestLibraryAccessors = new AndroidxTestLibraryAccessors(owner);

        public AndroidxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for appcompat (androidx.appcompat:appcompat)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getAppcompat() { return create("androidx.appcompat"); }

            /**
             * Creates a dependency provider for material (com.google.android.materia:materiall)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getMaterial() { return create("androidx.material"); }

        /**
         * Returns the group of libraries at androidx.core
         */
        public AndroidxCoreLibraryAccessors getCore() { return laccForAndroidxCoreLibraryAccessors; }

        /**
         * Returns the group of libraries at androidx.test
         */
        public AndroidxTestLibraryAccessors getTest() { return laccForAndroidxTestLibraryAccessors; }

    }

    public static class AndroidxCoreLibraryAccessors extends SubDependencyFactory {

        public AndroidxCoreLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for ktx (androidx.core:core-ktx)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getKtx() { return create("androidx.core.ktx"); }

    }

    public static class AndroidxTestLibraryAccessors extends SubDependencyFactory {

        public AndroidxTestLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.test:core)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("androidx.test.core"); }

            /**
             * Creates a dependency provider for junit (androidx.test.ext:junit)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getJunit() { return create("androidx.test.junit"); }

            /**
             * Creates a dependency provider for runner (androidx.test:runner)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getRunner() { return create("androidx.test.runner"); }

    }

    public static class EspressoLibraryAccessors extends SubDependencyFactory {

        public EspressoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (androidx.test.espresso:espresso-core)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("espresso.core"); }

    }

    public static class GlideLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public GlideLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for glide (com.github.bumptech.glide:glide)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("glide"); }

            /**
             * Creates a dependency provider for compiler (com.github.bumptech.glide:compiler)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getCompiler() { return create("glide.compiler"); }

    }

    public static class PluginLibraryAccessors extends SubDependencyFactory {
        private final PluginGradleLibraryAccessors laccForPluginGradleLibraryAccessors = new PluginGradleLibraryAccessors(owner);

        public PluginLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at plugin.gradle
         */
        public PluginGradleLibraryAccessors getGradle() { return laccForPluginGradleLibraryAccessors; }

    }

    public static class PluginGradleLibraryAccessors extends SubDependencyFactory {

        public PluginGradleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for android (com.android.tools.build:gradle)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getAndroid() { return create("plugin.gradle.android"); }

            /**
             * Creates a dependency provider for kotlin (org.jetbrains.kotlin:kotlin-gradle-plugin)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getKotlin() { return create("plugin.gradle.kotlin"); }

    }

    public static class RetrofitLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {
        private final RetrofitAdapterLibraryAccessors laccForRetrofitAdapterLibraryAccessors = new RetrofitAdapterLibraryAccessors(owner);

        public RetrofitLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for retrofit (com.squareup.retrofit2:retrofit)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> asProvider() { return create("retrofit"); }

        /**
         * Returns the group of libraries at retrofit.adapter
         */
        public RetrofitAdapterLibraryAccessors getAdapter() { return laccForRetrofitAdapterLibraryAccessors; }

    }

    public static class RetrofitAdapterLibraryAccessors extends SubDependencyFactory {

        public RetrofitAdapterLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for rxjava (com.squareup.retrofit2:adapter-rxjava3)
             * This dependency was declared in catalog libs.toml
             */
            public Provider<MinimalExternalModuleDependency> getRxjava() { return create("retrofit.adapter.rxjava"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final AndroidxVersionAccessors vaccForAndroidxVersionAccessors = new AndroidxVersionAccessors(providers, config);
        private final ComposeVersionAccessors vaccForComposeVersionAccessors = new ComposeVersionAccessors(providers, config);
        private final DependenciesVersionAccessors vaccForDependenciesVersionAccessors = new DependenciesVersionAccessors(providers, config);
        private final DmVersionAccessors vaccForDmVersionAccessors = new DmVersionAccessors(providers, config);
        private final GradleVersionAccessors vaccForGradleVersionAccessors = new GradleVersionAccessors(providers, config);
        private final JavaVersionAccessors vaccForJavaVersionAccessors = new JavaVersionAccessors(providers, config);
        private final KtxVersionAccessors vaccForKtxVersionAccessors = new KtxVersionAccessors(providers, config);
        private final VersionVersionAccessors vaccForVersionVersionAccessors = new VersionVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: android (7.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getAndroid() { return getVersion("android"); }

            /**
             * Returns the version associated to this alias: glide (4.14.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getGlide() { return getVersion("glide"); }

            /**
             * Returns the version associated to this alias: junit (4.13.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getJunit() { return getVersion("junit"); }

            /**
             * Returns the version associated to this alias: koom (2.2.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getKoom() { return getVersion("koom"); }

            /**
             * Returns the version associated to this alias: kotlin (1.7.20)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getKotlin() { return getVersion("kotlin"); }

            /**
             * Returns the version associated to this alias: ktlint (0.47.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getKtlint() { return getVersion("ktlint"); }

            /**
             * Returns the version associated to this alias: leakcanary (2.10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getLeakcanary() { return getVersion("leakcanary"); }

            /**
             * Returns the version associated to this alias: material (1.7.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getMaterial() { return getVersion("material"); }

            /**
             * Returns the version associated to this alias: mmkv (1.2.14)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getMmkv() { return getVersion("mmkv"); }

            /**
             * Returns the version associated to this alias: okhttp (4.10.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getOkhttp() { return getVersion("okhttp"); }

            /**
             * Returns the version associated to this alias: retrofit (2.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getRetrofit() { return getVersion("retrofit"); }

            /**
             * Returns the version associated to this alias: rxpermission (0.11)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getRxpermission() { return getVersion("rxpermission"); }

            /**
             * Returns the version associated to this alias: spotless (6.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getSpotless() { return getVersion("spotless"); }

        /**
         * Returns the group of versions at versions.androidx
         */
        public AndroidxVersionAccessors getAndroidx() { return vaccForAndroidxVersionAccessors; }

        /**
         * Returns the group of versions at versions.compose
         */
        public ComposeVersionAccessors getCompose() { return vaccForComposeVersionAccessors; }

        /**
         * Returns the group of versions at versions.dependencies
         */
        public DependenciesVersionAccessors getDependencies() { return vaccForDependenciesVersionAccessors; }

        /**
         * Returns the group of versions at versions.dm
         */
        public DmVersionAccessors getDm() { return vaccForDmVersionAccessors; }

        /**
         * Returns the group of versions at versions.gradle
         */
        public GradleVersionAccessors getGradle() { return vaccForGradleVersionAccessors; }

        /**
         * Returns the group of versions at versions.java
         */
        public JavaVersionAccessors getJava() { return vaccForJavaVersionAccessors; }

        /**
         * Returns the group of versions at versions.ktx
         */
        public KtxVersionAccessors getKtx() { return vaccForKtxVersionAccessors; }

        /**
         * Returns the group of versions at versions.version
         */
        public VersionVersionAccessors getVersion() { return vaccForVersionVersionAccessors; }

    }

    public static class AndroidxVersionAccessors extends VersionFactory  {

        private final AndroidxTestVersionAccessors vaccForAndroidxTestVersionAccessors = new AndroidxTestVersionAccessors(providers, config);
        public AndroidxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidx.appcompat (1.5.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getAppcompat() { return getVersion("androidx.appcompat"); }

        /**
         * Returns the group of versions at versions.androidx.test
         */
        public AndroidxTestVersionAccessors getTest() { return vaccForAndroidxTestVersionAccessors; }

    }

    public static class AndroidxTestVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public AndroidxTestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: androidx.test (1.4.0)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.toml
         */
        public Provider<String> asProvider() { return getVersion("androidx.test"); }

            /**
             * Returns the version associated to this alias: androidx.test.espresso (3.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getEspresso() { return getVersion("androidx.test.espresso"); }

            /**
             * Returns the version associated to this alias: androidx.test.ext (1.1.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getExt() { return getVersion("androidx.test.ext"); }

    }

    public static class ComposeVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public ComposeVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: compose (1.3.1)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.toml
         */
        public Provider<String> asProvider() { return getVersion("compose"); }

            /**
             * Returns the version associated to this alias: compose.compiler (1.3.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getCompiler() { return getVersion("compose.compiler"); }

            /**
             * Returns the version associated to this alias: compose.meterial (1.0.0-beta02)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getMeterial() { return getVersion("compose.meterial"); }

            /**
             * Returns the version associated to this alias: compose.navigation (1.0.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getNavigation() { return getVersion("compose.navigation"); }

            /**
             * Returns the version associated to this alias: compose.paging (1.0.0-alpha16)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getPaging() { return getVersion("compose.paging"); }

    }

    public static class DependenciesVersionAccessors extends VersionFactory  {

        public DependenciesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: dependencies.update (0.44.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getUpdate() { return getVersion("dependencies.update"); }

    }

    public static class DmVersionAccessors extends VersionFactory  {

        public DmVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: dm.plugin (0.0.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getPlugin() { return getVersion("dm.plugin"); }

    }

    public static class GradleVersionAccessors extends VersionFactory  {

        public GradleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: gradle.publish (1.1.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getPublish() { return getVersion("gradle.publish"); }

    }

    public static class JavaVersionAccessors extends VersionFactory  implements VersionNotationSupplier {

        public JavaVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the version associated to this alias: java (11)
         * If the version is a rich version and that its not expressible as a
         * single version string, then an empty string is returned.
         * This version was declared in catalog libs.toml
         */
        public Provider<String> asProvider() { return getVersion("java"); }

            /**
             * Returns the version associated to this alias: java.major (11)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getMajor() { return getVersion("java.major"); }

    }

    public static class KtxVersionAccessors extends VersionFactory  {

        public KtxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: ktx.core (1.9.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getCore() { return getVersion("ktx.core"); }

    }

    public static class VersionVersionAccessors extends VersionFactory  {

        private final VersionCatalogVersionAccessors vaccForVersionCatalogVersionAccessors = new VersionCatalogVersionAccessors(providers, config);
        public VersionVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.version.catalog
         */
        public VersionCatalogVersionAccessors getCatalog() { return vaccForVersionCatalogVersionAccessors; }

    }

    public static class VersionCatalogVersionAccessors extends VersionFactory  {

        public VersionCatalogVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: version.catalog.update (0.7.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.toml
             */
            public Provider<String> getUpdate() { return getVersion("version.catalog.update"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class PluginAccessors extends PluginFactory {
        private final AndroidPluginAccessors baccForAndroidPluginAccessors = new AndroidPluginAccessors(providers, config);
        private final DependenciesPluginAccessors baccForDependenciesPluginAccessors = new DependenciesPluginAccessors(providers, config);
        private final GradlePluginAccessors baccForGradlePluginAccessors = new GradlePluginAccessors(providers, config);
        private final JavaPluginAccessors baccForJavaPluginAccessors = new JavaPluginAccessors(providers, config);
        private final KotlinPluginAccessors baccForKotlinPluginAccessors = new KotlinPluginAccessors(providers, config);
        private final VersionPluginAccessors baccForVersionPluginAccessors = new VersionPluginAccessors(providers, config);

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for ktlint to the plugin id 'com.pinterest:ktlint'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getKtlint() { return createPlugin("ktlint"); }

            /**
             * Creates a plugin provider for spotless to the plugin id 'com.diffplug.spotless'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getSpotless() { return createPlugin("spotless"); }

        /**
         * Returns the group of bundles at plugins.android
         */
        public AndroidPluginAccessors getAndroid() { return baccForAndroidPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.dependencies
         */
        public DependenciesPluginAccessors getDependencies() { return baccForDependenciesPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.gradle
         */
        public GradlePluginAccessors getGradle() { return baccForGradlePluginAccessors; }

        /**
         * Returns the group of bundles at plugins.java
         */
        public JavaPluginAccessors getJava() { return baccForJavaPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.kotlin
         */
        public KotlinPluginAccessors getKotlin() { return baccForKotlinPluginAccessors; }

        /**
         * Returns the group of bundles at plugins.version
         */
        public VersionPluginAccessors getVersion() { return baccForVersionPluginAccessors; }

    }

    public static class AndroidPluginAccessors extends PluginFactory {

        public AndroidPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for android.application to the plugin id 'com.android.application'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getApplication() { return createPlugin("android.application"); }

            /**
             * Creates a plugin provider for android.library to the plugin id 'com.android.library'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getLibrary() { return createPlugin("android.library"); }

    }

    public static class DependenciesPluginAccessors extends PluginFactory {

        public DependenciesPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for dependencies.update to the plugin id 'com.github.ben-manes.versions'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getUpdate() { return createPlugin("dependencies.update"); }

    }

    public static class GradlePluginAccessors extends PluginFactory {

        public GradlePluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for gradle.publish to the plugin id 'com.gradle.plugin-publish'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getPublish() { return createPlugin("gradle.publish"); }

    }

    public static class JavaPluginAccessors extends PluginFactory {

        public JavaPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for java.library to the plugin id 'org.gradle.java-library'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getLibrary() { return createPlugin("java.library"); }

    }

    public static class KotlinPluginAccessors extends PluginFactory {

        public KotlinPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for kotlin.android to the plugin id 'org.jetbrains.kotlin.android'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getAndroid() { return createPlugin("kotlin.android"); }

            /**
             * Creates a plugin provider for kotlin.jvm to the plugin id 'org.jetbrains.kotlin.jvm'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getJvm() { return createPlugin("kotlin.jvm"); }

            /**
             * Creates a plugin provider for kotlin.kapt to the plugin id 'org.jetbrains.kotlin.kapt'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getKapt() { return createPlugin("kotlin.kapt"); }

    }

    public static class VersionPluginAccessors extends PluginFactory {
        private final VersionCatalogPluginAccessors baccForVersionCatalogPluginAccessors = new VersionCatalogPluginAccessors(providers, config);

        public VersionPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of bundles at plugins.version.catalog
         */
        public VersionCatalogPluginAccessors getCatalog() { return baccForVersionCatalogPluginAccessors; }

    }

    public static class VersionCatalogPluginAccessors extends PluginFactory {

        public VersionCatalogPluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for version.catalog.update to the plugin id 'nl.littlerobots.version-catalog-update'
             * This plugin was declared in catalog libs.toml
             */
            public Provider<PluginDependency> getUpdate() { return createPlugin("version.catalog.update"); }

    }

}

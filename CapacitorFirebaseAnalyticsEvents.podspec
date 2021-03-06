
  Pod::Spec.new do |s|
    s.name = 'CapacitorFirebaseAnalyticsEvents'
    s.version = '0.0.4'
    s.summary = 'Capacitor Firebase Analytics plugin for suggested events.'
    s.license = 'MIT'
    s.homepage = 'https://github.com/baumblatt/capacitor-firebase-analytics-events.git'
    s.author = 'Bernardo Baumblatt'
    s.source = { :git => 'https://github.com/baumblatt/capacitor-firebase-analytics-events.git', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '11.0'
    s.dependency 'Capacitor'
    s.dependency 'Firebase'
    s.dependency 'Firebase/Core'
    s.static_framework = true
  end
